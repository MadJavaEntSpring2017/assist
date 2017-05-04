(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('commitList', {
            controller: CommitListController,
            controllerAs: 'vm',
            templateUrl: 'components/commit/commit-list.html',
            bindings: {
                commits: '<',
                onUpdate: '&'
            },
            require: {}
        });

    CommitListController.$inject = ['$mdDialog', '$stateParams', '$q', 'rosterService', 'messageService'];

    function CommitListController($mdDialog, $stateParams, $q, rosterService, messageService) {
        var vm = this;

        vm.showSelectCommitDialog = showSelectCommitDialog;

        vm.$onInit = function () {
            $q.all({
                roster: rosterService.getRosterDetails($stateParams.rosterId)
            }).then(function (results) {
                vm.roster = results.roster;
            });
        };

        function showSelectCommitDialog(event) {
            $mdDialog.show({
                targetEvent: event,
                controller: 'SelectCommitDialogController',
                controllerAs: 'vm',
                templateUrl: 'components/commit/select-commit-dialog.html',
                locals: {
                    roster: vm.roster
                }
            }).then(function (playerIds) {
                if (playerIds) {
                    save(playerIds);
                }
            });
        }

        function save(playerIds) {
            var writeRequest = createWriteRequest(playerIds);
            rosterService.createCommitsForRoster(vm.roster.id, writeRequest)
                .then(function (results) {
                    messageService.showSuccessMessage();
                    updateCommits(results);
                }).catch(function () {
                    messageService.showErrorMessage();
                });
        }

        function updateCommits(commits) {
            vm.onUpdate({
                $event: {
                    commits: commits
                }
            });
        }

        function createWriteRequest(playerIds) {
            return {
                playerIdList: playerIds
            }
        }
    }
})();