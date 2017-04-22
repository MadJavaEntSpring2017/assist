(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('messageService', messageService);

    messageService.$inject = ['Flash'];

    function messageService(Flash) {
        return {
            showSuccessMessage: showSuccessMessage,
            showErrorMessage: showErrorMessage
        };

        function showSuccessMessage() {
            var message = 'Success';
            var id = Flash.create(
                'success', message, 3000, {}, true
            );
        }

        function showErrorMessage() {
            var message = 'Error';
            var id = Flash.create(
                'danger', message, 3000, {}, true
            );
        }
    }
})();