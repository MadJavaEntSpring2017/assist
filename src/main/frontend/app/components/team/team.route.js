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
                },
                rosters: function (rosterService, $stateParams) {
                    return rosterService.getRostersByTeam($stateParams.teamId);
                }
            }
        };

        var teamAddState = {
            name: 'main.teams-add',
            url: '/teams/add',
            component: 'team'
        };

        var teamRosterAddState = {
            name: 'main.team-rosters-add',
            url: '/teams/:teamId/rosters',
            component: 'roster'
        };

        $stateProvider
            .state(teamListState)
            .state(teamState)
            .state(teamAddState)
            .state(teamRosterAddState);
    }
})();