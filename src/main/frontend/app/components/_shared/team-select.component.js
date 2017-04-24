(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('teamSelect', {
            controller: TeamSelectController,
            controllerAs: 'vm',
            templateUrl: 'components/_shared/team-select.html',
            require: {},
            bindings: {
                team: '<',
                onSelect: '&'
            }
        });

    TeamSelectController.$inject = ['$q', 'teamService'];

    function TeamSelectController($q, teamService) {
        var vm = this;

        vm.selectTeam = selectTeam;

        function selectTeam() {
            vm.onSelect({
                $event: {
                    team: vm.team
                }
            });
        }

        vm.$onInit = function() {
            $q.all({
                teams: teamService.getAllTeams()
            }).then(function (results) {
                vm.teams = results.teams;
            });
        };

        vm.$onChanges = function (changes) {
            if (changes.team) {
                vm.team = angular.copy(vm.team);
            }
        };
    }
})();