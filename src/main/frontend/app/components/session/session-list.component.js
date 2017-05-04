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

    SessionListController.$inject = ['$state', '$stateParams'];

    function SessionListController($state, $stateParams) {
        var vm = this;

        vm.edit = edit;

        vm.$onInit = function () {
            vm.seasonId = $stateParams.seasonId;
        };

        function edit(session) {
            $state.go('main.session-details', { sessionId: session.id });
        }
    }
})();