(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('splitService', splitService);

    splitService.$inject = ['apiService'];

    function splitService(apiService) {

        return {
            getAllSplits: getAllSplits,
            getSplitDetails: getSplitDetails,
            updateSplit: updateSplit,
            createSplit: createSplit
        };

        function createSplit(writeRequest) {
            return apiService.post('/splits', writeRequest);
        }

        function updateSplit(splitId, writeRequest) {
            return apiService.put('/splits/' + splitId, writeRequest);
        }

        function getSplitDetails(splitId) {
            return apiService.get('/splits/' + splitId + '/details');
        }

        function getAllSplits() {
            return apiService.get('/splits');
        }
    }
})();