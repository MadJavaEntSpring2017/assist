(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('splitSelect', {
            controller: SplitSelectController,
            controllerAs: 'vm',
            templateUrl: 'components/_shared/split-select.html',
            bindings: {
                split: '<',
                onSelect: '&'
            },
            require: {}
        });

    SplitSelectController.$inject = ['$q', 'splitService'];

    function SplitSelectController($q, splitService) {
        var vm = this;

        vm.selectSplit = selectSplit;

        function selectSplit() {
            vm.onSelect({
                $event: {
                    split: vm.split
                }
            });
        }

        vm.$onInit = function () {
            $q.all({
                splits: splitService.getAllSplits()
            }).then(function (results) {
                vm.splits = results.splits;
            });
        };

        vm.$onChanges = function (changes) {
            if (changes.split) {
                vm.split = angular.copy(vm.split);
            }
        };
    }
})();