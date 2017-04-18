(function () {
    'use strict';
    angular
        .module('assist-web')
        .controller('View1Controller', View1Controller);

    View1Controller.$inject = ['$log', 'teamService'];

    function View1Controller($log, teamService) {
        var vm = this;

        getAllTeams();
        getTeam(1);

        function getTeam(id) {
            teamService.getTeam(id)
                .then(
                    function (results) {
                        $log.debug(results);
                    },
                    function (error) {
                        $log.debug('Error getting team: ' + error);
                    }
                );
        }

        function getAllTeams() {
            teamService.getAllTeams()
                .then(
                    function (results) {
                        $log.debug(results);
                        vm.teams = results;
                    },
                    function (error) {
                        $log.debug('Error getting teams: ' + error);

                    }
                );
        }
    }
})();