(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('seasonSelect', {
            controller: SeasonSelectController,
            controllerAs: 'vm',
            templateUrl: 'components/_shared/season-select.html',
            bindings: {
                season: '<',
                onSelect: '&',
                required: '@'
            },
            require: {
                form: '^form'
            }
        });

    SeasonSelectController.$inject = ['$q', 'seasonService'];

    function SeasonSelectController($q, seasonService) {
        var vm = this;

        vm.selectSeason = selectSeason;

        function selectSeason() {
            vm.onSelect({
                $event: {
                    season: vm.season
                }
            });
        }

        vm.$onInit = function () {
            $q.all({
                seasons: seasonService.getAllSeasons()
            }).then(function (results) {
                vm.seasons = results.seasons;
            });
        };

        vm.$onChanges = function (changes) {
            if (changes.season) {
                vm.season = angular.copy(vm.season);
            }
        };
    }
})();