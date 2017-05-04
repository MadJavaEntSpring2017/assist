(function () {
    'use strict';
    angular
        .module('assist-web')
        .controller('SelectCommitDialogController', SelectCommitDialogController);

    SelectCommitDialogController.$inject = ['$mdDialog', 'locals', '$q', 'teamService', '$state', 'rosterService'];

    function SelectCommitDialogController($mdDialog, locals, $q, teamService, $state, rosterService) {
        var vm = this;
        var selectedPlayerIds = [];

        vm.closeDialog = closeDialog;
        vm.toggleSelected = toggleSelected;
        vm.save = save;

        activate();

        function activate() {
            $q.all({
                players: teamService.getAllPlayersByTeam(locals.roster.teamId)
            }).then(function (results) {
                vm.commits = locals.roster.commits;
                vm.players = results.players;

                vm.commits.forEach(function (commit) {
                    vm.players.forEach(function (player) {
                        if (commit.playerId === player.id) {
                            player.selected = true;
                        } else {
                            player.selected = false;
                        }
                    });
                });
            });
        }

        function toggleSelected(selectedPlayer) {
            vm.players.forEach(function (player) {
                if (player.id === selectedPlayer.id) {
                    player.selected = !selectedPlayer.selected;
                }
            });
        }

        function closeDialog() {
            $mdDialog.hide();
        }

        function save() {
            $mdDialog
                .hide()
                .then(function () {
                    vm.players.forEach(function (player) {
                        if (player.selected === true) {
                            selectedPlayerIds.push(player.id);
                        }
                    });
                }).then(function () {
                    var writeRequest = createWriteRequest();
                    rosterService.createCommitsForRoster(locals.roster.id, writeRequest)
                        .then(function (results) {
                            $state.go('main.roster-details', { rosterId: results.rosterId });
                        });
                });
        }

        function createWriteRequest() {
            return {
                playerIdList: selectedPlayerIds
            };
        }
    }
})();