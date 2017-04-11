(function () {
    'use strict';
    angular
        .module('assist-web')
        .config(view2RouteConfig);

    view2RouteConfig.$inject = ['$stateProvider'];

    function view2RouteConfig($stateProvider) {
        $stateProvider
            .state('main.view2', {
                url: '/view2',
                templateUrl: 'components/view2/view2.html',
                controller: 'View2Controller as vm'
            });
    }
})();