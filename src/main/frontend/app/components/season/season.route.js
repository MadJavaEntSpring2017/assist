(function () {
    'use strict';
    angular
        .module('assist-web')
        .config(seasonRouteConfig);

    seasonRouteConfig.$inject = ['$stateProvider'];

    function seasonRouteConfig($stateProvider) {
        var seasonListState = {
            name: 'main.seasons',
            url: '/seasons',
            component: 'seasonList',
            resolve: {
                seasons: function (seasonService) {
                    return seasonService.getAllSeasons();
                }
            }
        };

        $stateProvider
            .state(seasonListState);
    }
})();