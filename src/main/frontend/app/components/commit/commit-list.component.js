(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('commitList', {
            controller: CommitListController,
            controllerAs: 'vm',
            templateUrl: 'components/commit/commit-list.html',
            bindings: {
                commits: '<'
            },
            require: {}
        });

    CommitListController.$inject = ['$mdDialog', '$stateParams', '$q', 'rosterService'];

    function CommitListController($mdDialog, $stateParams, $q, rosterService) {
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
            }).then(function (results) {
                console.log(results); //todo delete
            });
        }
    }
})();