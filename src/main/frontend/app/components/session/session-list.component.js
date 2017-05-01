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

    SessionListController.$inject = ['$state'];

    function SessionListController($state) {
        var vm = this;

        vm.edit = edit;

        function edit(session) {
            $state.go('main.session-details', { sessionId: session.id });
        }
    }
})();