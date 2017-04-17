(function () {
    'use strict';
    angular
        .module('assist-web')
        .controller('View2Controller', View2Controller);

    View2Controller.$inject = ['$log', 'leagueService'];

    function View2Controller($log, leagueService) {
        var vm = this;
        vm.title = 'at view 2';

        getAllLeagues();

        function getAllLeagues() {
            leagueService.getAllLeagues()
                .then(
                    function (results) {
                        $log.debug(results);
                    },
                    function (error) {
                        $log.debug('Error getting leagues: ' + error);
                    }
                );
        }
    }
})();