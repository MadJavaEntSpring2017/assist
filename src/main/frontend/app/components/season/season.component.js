(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('season', {
            controller: SeasonController,
            controllerAs: 'vm',
            templateUrl: 'components/season/season.html',
            bindings: {
                season: '<',
                sessions: '<'
            },
            require: {}
        });

    SeasonController.$inject = ['seasonService', 'messageService', '$state'];

    function SeasonController(seasonService, messageService, $state) {
        var vm = this;

        vm.save = save;

        vm.$onInit = function () {
            vm.season = vm.season ? vm.season : {};
            vm.season.active = vm.season.active ? vm.season.active : false;
            vm.sessions = vm.sessions ? vm.sessions : {};
        };

        function save() {
            var writeRequest = createWriteRequest();

            var savePromise;
            if (vm.season && vm.season.id) {
                savePromise = seasonService.updateSeason(vm.season.id, writeRequest);
            } else {
                savePromise = seasonService.createSeason(writeRequest);
            }

            savePromise
                .then(function (results) {
                    messageService.showSuccessMessage();
                    $state.go('main.season-details', { seasonId: results.id });
                }).catch(function () {
                    messageService.showErrorMessage();
                });
        }

        function createWriteRequest() {
            return {
                name: vm.season.name,
                active: vm.season.active
            };
        }
    }
})();