(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('seasonSessionList', {
            controller: SeasonSessionList,
            controllerAs: 'vm',
            templateUrl: 'components/season/season-session-list.html',
            bindings: {
                sessions: '<'
            },
            require: {}
        });

    SeasonSessionList.$inject = [];

    function SeasonSessionList() {
        var vm = this;
    }
})();