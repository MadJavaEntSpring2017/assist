(function () {
    'use strict';
    angular
        .module('assist-web')
        .config(teamRouteConfig);

    teamRouteConfig.$inject = ['$stateProvider'];

    function teamRouteConfig($stateProvider) {
        var teamListState = {
            name: 'main.teams',
            url: '/teams',
            component: 'teamList',
            resolve: {
                teams: function (teamService) {
                    return teamService.getAllTeams();
                }
            }
        };

        var teamState = {
            name: 'main.team',
            url: '/teams/:teamId',
            component: 'team',
            resolve: {
                team: function (teamService, $stateParams) {
                    return teamService.getTeam($stateParams.teamId);
                }
            }
        };

        var teamAddState = {
            name: 'main.teams-add',
            url: '/teams/add',
            component: 'team'
        };

        $stateProvider
            .state(teamListState)
            .state(teamState)
            .state(teamAddState);
    }
})();