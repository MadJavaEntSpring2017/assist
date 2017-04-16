(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('TeamService', TeamService);

    TeamService.$inject = ['$log'];

    function TeamService($log) {
        var vm = this;
        $log.debug(vm);
    }
})();