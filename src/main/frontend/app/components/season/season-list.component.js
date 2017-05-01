(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('seasonList', {
            controller: SeasonListController,
            controllerAs: 'vm',
            templateUrl: 'components/season/season-list.html',
            bindings: {
                seasons: '<'
            },
            require: {}
        });

    SeasonListController.$inject = [];

    function SeasonListController() {
        var vm = this;
    }
})();