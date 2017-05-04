(function () {
    'use strict';
    angular
        .module('assist-web')
        .config(sessionRouteConfig);

    sessionRouteConfig.$inject = ['$stateProvider'];

    function sessionRouteConfig($stateProvider) {
        var sessionListState = {
            name: 'main.sessions',
            url: '/sessions',
            component: 'sessionList',
            resolve: {
                sessions: function (sessionService) {
                    return sessionService.getAllSessions();
                }
            }
        };

        var sessionDetailState = {
            name: 'main.session-details',
            url: '/sessions/:sessionId/details',
            component: 'session',
            resolve: {
                session: function (sessionService, $stateParams) {
                    return sessionService.getSessionDetails($stateParams.sessionId);
                },
                rosters: function (rosterService, $stateParams) {
                    return rosterService.getRostersBySession($stateParams.sessionId);
                }
            }
        };

        var sessionAddState = {
            name: 'main.sessions-add',
            url: '/sessions/add',
            component: 'session'
        };

        var sessionRosterAddState = {
            name: 'main.session-rosters-add',
            url: '/session/:sessionId/rosters',
            component: 'roster'
        };

        $stateProvider
            .state(sessionListState)
            .state(sessionDetailState)
            .state(sessionAddState)
            .state(sessionRosterAddState);
    }
})();