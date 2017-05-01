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

        $stateProvider
            .state(sessionListState);
    }
})();