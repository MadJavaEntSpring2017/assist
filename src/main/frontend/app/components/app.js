(function () {
    'use strict';

// Declare app level module which depends on views, and components
    angular
        .module('assist-web', [
            'ngAnimate', 'ngAria',
            'ui.router', 'ngMessages',
            'ngMaterial',
            'ngRoute',
            // 'myApp.view1',
            // 'myApp.view2',
            'myApp.version'])
        .config(configFunc);
    // .config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    //     // $locationProvider.hashPrefix('!');
    //
    //     $routeProvider.otherwise({redirectTo: '/view1'});
    // }]);

    configFunc.$inject = ['$locationProvider', '$routeProvider', '$stateProvider', '$urlRouterProvider',
                            '$httpProvider'];

    function configFunc($locationProvider, $routeProvider, $stateProvider, $urlRouterProvider,
                        $httpProvider) {
        $locationProvider.hashPrefix('!');
        // $routeProvider.otherwise({redirectTo: '/view1'});
        // $urlRouterProvider.otherwise('/view1');
        $urlRouterProvider.otherwise('/home');

        $stateProvider
            .state('main', {
                abstract: true,
                controller: 'ShellController as vm',
                templateUrl: 'components/shell/shell.html'
            })
            .state('main.home', {
                url: '/home',
                templateUrl: 'components/home/home.html'
            });
    }
})();