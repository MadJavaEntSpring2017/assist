(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('splitList', {
            controller: SplitListController,
            controllerAs: 'vm',
            templateUrl: 'components/split/split-list.html',
            bindings: {
                splits: '<'
            },
            require: {}
        });

    SplitListController.$inject = [];

    function SplitListController() {
        var vm = this;
    }
})();