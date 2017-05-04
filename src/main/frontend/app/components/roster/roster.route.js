(function () {
    'use strict';
    angular
        .module('assist-web')
        .config(rosterRouteConfig);

    rosterRouteConfig.$inject = ['$stateProvider'];

    function rosterRouteConfig($stateProvider) {
        var rosterListState = {
            name: 'main.rosters',
            url: '/rosters',
            component: 'rosterList',
            resolve: {
                rosters: function (rosterService) {
                    return rosterService.getAllRosters();
                }
            }
        };

        var rosterDetailState = {
            name: 'main.roster-details',
            url: '/rosters/:rosterId/details',
            component: 'roster',
            resolve: {
                roster: function (rosterService, $stateParams) {
                    return rosterService.getRosterDetails($stateParams.rosterId);
                },
                commits: function (commitService, $stateParams) {
                    return commitService.getCommitsByRoster($stateParams.rosterId);
                }
            }
        };

        var rosterAddState = {
            name: 'main.rosters-add',
            url: '/rosters/add',
            component: 'roster'
        };

        // var rosterCommitListAddState = {
        //     name: 'main.roster-commits-add',
        //     url: '/roster/:rosterId/commits',
        //     component: 'commitList'
        // };

        $stateProvider
            .state(rosterListState)
            .state(rosterDetailState)
            .state(rosterAddState);
            // .state(rosterCommitListAddState);
    }
})();