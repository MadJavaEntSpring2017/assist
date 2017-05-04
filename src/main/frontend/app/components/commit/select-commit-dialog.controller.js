(function () {
    'use strict';
    angular
        .module('assist-web')
        .controller('SelectCommitDialogController', SelectCommitDialogController);

    SelectCommitDialogController.$inject = ['$mdDialog', 'locals', '$q', 'teamService', 'commitService'];

    function SelectCommitDialogController($mdDialog, locals, $q, teamService, commitService) {
        var vm = this;
        var roster;
        var selectedPlayerIds = [];

        vm.closeDialog = closeDialog;
        vm.toggleSelected = toggleSelected;
        vm.selectCommits = selectCommits;

        activate();

        function activate() {
            roster = locals.roster;
            $q.all({
                players: teamService.getAllPlayersByTeam(roster.teamId),
                commits: commitService.getCommitsByRoster(roster.id)
            }).then(function (results) {
                vm.commits = results.commits;
                vm.players = results.players;

                // go through initially and set all to false
                vm.players.forEach(function (player) {
                    player.selected = false;
                });

                // go through again and set matches to true
                vm.commits.forEach(function (commit) {
                    vm.players.forEach(function (player) {
                        if (commit.playerId === player.id) {
                            player.selected = true;
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

        function selectCommits() {
            vm.players.forEach(function (player) {
                if (player.selected === true) {
                    selectedPlayerIds.push(player.id);
                }
            });

            $mdDialog
                .hide(selectedPlayerIds);
        }
    }
})();