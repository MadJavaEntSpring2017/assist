(function () {
    'use strict';

// Declare app level module which depends on views, and components
    angular
        .module('assist-web', [
            'ngAnimate', 'ngAria',
            'ui.router', 'ngMessages',
            'ngMaterial',
            'ngRoute', 'smart-table',
            'ngFlash',
            'myApp.version'])
        .config(configFunc);
    // .config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    //     // $locationProvider.hashPrefix('!');
    //
    //     $routeProvider.otherwise({redirectTo: '/view1'});
    // }]);

    configFunc.$inject = ['$locationProvider', '$routeProvider', '$stateProvider', '$urlRouterProvider',
                            '$httpProvider', 'FlashProvider'];

    function configFunc($locationProvider, $routeProvider, $stateProvider, $urlRouterProvider,
                        $httpProvider, FlashProvider) {
        // $locationProvider.hashPrefix('!');
        // $routeProvider.otherwise({redirectTo: '/view1'});
        // $urlRouterProvider.otherwise('/view1');
        // TODO: remove

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

        // found from http://aboutcode.net/2013/07/27/json-date-parsing-angularjs.html
        $httpProvider.defaults.transformResponse.push(function(responseData){
            convertDateStringsToDates(responseData);
            return responseData;
        });

        var regexIso8601 = /^([\+-]?\d{4}(?!\d{2}\b))((-?)((0[1-9]|1[0-2])(\3([12]\d|0[1-9]|3[01]))?|W([0-4]\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\d|[12]\d{2}|3([0-5]\d|6[1-6])))([T\s]((([01]\d|2[0-3])((:?)[0-5]\d)?|24\:?00)([\.,]\d+(?!:))?)?(\17[0-5]\d([\.,]\d+)?)?([zZ]|([\+-])([01]\d|2[0-3]):?([0-5]\d)?)?)?)?$/;

        function convertDateStringsToDates(input) {
            // Ignore things that aren't objects.
            if (typeof input !== "object") return input;

            for (var key in input) {
                if (!input.hasOwnProperty(key)) continue;

                var value = input[key];
                var match;
                // Check for string properties which look like dates.
                // TODO: Improve this regex to better match ISO 8601 date strings.
                if (typeof value === "string" && (match = value.match(regexIso8601))) {
                    // Assume that Date.parse can parse ISO 8601 strings, or has been shimmed in older browsers to do so.
                    var milliseconds = Date.parse(match[0]);
                    if (!isNaN(milliseconds)) {
                        input[key] = new Date(milliseconds);
                    }
                } else if (typeof value === "object") {
                    // Recurse into object
                    convertDateStringsToDates(value);
                }
            }
        }

    }
})();