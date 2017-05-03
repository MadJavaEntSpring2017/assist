(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('commitService', commitService);

    commitService.$inject = ['apiService'];

    function commitService(apiService) {
        return {
            getCommitsByRoster: getCommitsByRoster
        };

        function getCommitsByRoster(rosterId) {
            return apiService.get('/rosters/' + rosterId + '/commits');
        }
    }
})();