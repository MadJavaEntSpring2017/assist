(function () {
    'use strict';
    angular
        .module('assist-web')
        .controller('View1Controller', View1Controller);

    View1Controller.$inject = [];

    function View1Controller() {
        var vm = this;
        vm.title = 'at view 1';
        console.log('at view 1');
    }
})();