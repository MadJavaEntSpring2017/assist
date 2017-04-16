(function () {
    'use strict';
    angular
        .module('assist-web')
        .controller('View1Controller', View1Controller);

    View1Controller.$inject = ['$q', 'teamService'];

    function View1Controller($q, teamService) {
        var vm = this;
        vm.title = 'at view 1';
        console.log('at view 1');


    }
})();