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

        var seasonDetailState = {
            name: 'main.season-details',
            url: '/seasons/:seasonId/details',
            component: 'season',
            resolve: {
                season: function (seasonService, $stateParams) {
                    return seasonService.getSeasonDetails($stateParams.seasonId);
                },
                sessions: function (sessionService, $stateParams) {
                    return sessionService.getAllSessionDetailsBySeason($stateParams.seasonId);
                }
            }
        };

        var seasonAddState = {
            name: 'main.seasons-add',
            url: '/seasons/add',
            component: 'season'
        };

        var seasonSessionAddState = {
            name: 'main.season-sessions-add',
            url: '/seasons/:seasonId/sessions',
            component: 'session'
        };

        $stateProvider
            .state(seasonListState)
            .state(seasonDetailState)
            .state(seasonAddState)
            .state(seasonSessionAddState);
    }
})();