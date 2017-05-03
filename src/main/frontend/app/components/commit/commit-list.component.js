(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('commitList', {
            controller: CommitListController,
            controllerAs: 'vm',
            templateUrl: 'components/commit/commit-list.html',
            bindings: {
                commits: '<'
            },
            require: {}
        });

    CommitListController.$inject = [];

    function CommitListController() {
        var vm = this;
    }
})();