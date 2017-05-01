(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('sessionList', {
            controller: SessionListController,
            controllerAs: 'vm',
            templateUrl: 'components/session/session-list.html',
            bindings: {
                sessions: '<'
            },
            require: {}
        });

    SessionListController.$inject = [];

    function SessionListController() {
        var vm = this;
    }
})();