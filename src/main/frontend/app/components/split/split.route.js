(function () {
    'use strict';
    angular
        .module('assist-web')
        .config(splitRouteConfig);

    splitRouteConfig.$inject = ['$stateProvider'];

    function splitRouteConfig($stateProvider) {
        var splitListState = {
            name: 'main.splits',
            url: '/splits',
            component: 'splitList',
            resolve: {
                splits: function (splitService) {
                    return splitService.getAllSplits();
                }
            }
        };

        var splitDetailState = {
            name: 'main.split-details',
            url: '/splits/:splitId/details',
            component: 'split',
            resolve: {
                split: function (splitService, $stateParams) {
                    return splitService.getSplitDetails($stateParams.splitId);
                }
            }
        };

        var splitAddState = {
            name: 'main.splits-add',
            url: '/splits/add',
            component: 'split'
        };

        $stateProvider
            .state(splitListState)
            .state(splitDetailState)
            .state(splitAddState);
    }
})();