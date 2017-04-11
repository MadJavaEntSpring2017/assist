(function () {
    'use strict';
    angular
        .module('assist-web')
        .controller('View2Controller', View2Controller);

    View2Controller.$inject = [];

    function View2Controller() {
        var vm = this;
        vm.title = 'at view 2';
    }
})();