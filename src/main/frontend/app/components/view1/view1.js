(function () {
    'use strict';
    angular
        .module('assist-web')
        .controller('View1Controller', View1Controller);

    View1Controller.$inject = ['$q'];

    function View1Controller($q) {
        var vm = this;
        vm.title = 'at view 1';
        console.log('at view 1');


    }
})();