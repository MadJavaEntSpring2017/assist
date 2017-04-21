(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('menuBar', {
            templateUrl: 'components/menu-bar/menu-bar.html',
            controller: MenuBarController,
            controllerAs: 'vm',
            require: {},
            bindings: {}
        });

    MenuBarController.$inject = [];

    function MenuBarController() {
        var vm = this;
    }
})();