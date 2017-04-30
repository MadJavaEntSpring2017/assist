(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('split', {
            controller: SplitController,
            controllerAs: 'vm',
            templateUrl: 'components/split/split.html',
            bindings: {
                split: '<'
            },
            require: {}
        });

    SplitController.$inject = ['splitService', 'messageService', '$state'];

    function SplitController(splitService, messageService, $state) {
        var vm = this;

        vm.save = save;

        vm.$onInit = function () {
            vm.split = vm.split ? vm.split : {};
        };

        function save() {
            var writeRequest = createWriteRequest();

            var savePromise;
            if (vm.split && vm.split.id) {
                savePromise = splitService.updateSplit(vm.split.id, writeRequest);
            } else {
                savePromise = splitService.createSplit(writeRequest);
            }

            savePromise
                .then(function(results) {
                    $state.go('main.split-details', { splitId: results.id });
                    messageService.showSuccessMessage()
                })
                .catch(function() {
                    messageService.showErrorMessage()
                });
        }

        function createWriteRequest() {
            return {
                name: vm.split.name
            };
        }
    }
})();