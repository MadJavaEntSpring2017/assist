(function () {
    'use strict';
    angular
        .module('assist-web')
        .config(view1RouteConfig);

    view1RouteConfig.$inject = ['$stateProvider'];

    function view1RouteConfig($stateProvider) {
        $stateProvider
            .state('main.view1', {
                url: '/view1',
                templateUrl: 'components/view1/view1.html',
                controller: 'View1Controller as vm'
            });
    }
})();