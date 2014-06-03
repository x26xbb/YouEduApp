$(function() {
    $('#wrapper').css('height', $(window).height());
    $(window).resize(function() {
        $('#wrapper').css('height', $(window).height());
    });

    var array_colors = ['789a8f', '6da4c1', '28c48d', 'ecd6b7', '2273db', '349c41', '3cb717', 'd102b4', 'd0afe0', 'd595f6', '7aa457', '2fb140', '4b438b', '26af41', '464bd6', '7a34a9', 'cd4d1e', '473fe8', 'b11dfe', '3ada6f', 'f3fc92', '66e434', '7c6bf5', 'ee3b78', 'c40b31', '979701', '87e008', 'c624d8', '3586b0', 'a9058f', '7cd179', '715168', '897e27', '2a56dd', 'aec2b', 'a33a39', 'f205e7', '4467f3', 'bf8262', 'b154b4', 'b23925', '880a6b', '837b88', '14899b', 'eb92a4', 'c60bfd', '58d9f3', '107182', 'aa9708', '88ccbf', '98dc48', '158091', 'd01f3e', '7abd42', '26a4a5', '425d7d', 'fb0366', '3a3fc', 'dbc018', '84c303', 'a0284f', 'ec2c3a', 'dd5379', '234ccf', 'b18238', '5a1973', '43f744', '5ab6c8', 'ebe9f2', '1b93ac', '797ac6', 'e4ea68', 'c4888d', '6f5b99', 'a547a0', '6ff32b', 'fe2817', '845e38', '807b95', 'f08384', '9a7515', '3c64a6', 'c8f542', '28abcb', 'dd3f9', 'cd4a2a', '52e4a5', 'dda15b', 'b81da9', 'bc898', '221eec', '42a797', '9bca87', '201ffc', 'f02fa7', '13c32e', 'd4dbf4', '697d90', 'deb651', 'fa5f0c', '7517de', '48629', '16cd2', '7f2fb5', '8c3408', '9d2ad5', '4324e4', '98763d', '916ea6', 'c730bb', 'f1bc37', 'f3c5d0', '440b34', '1923fe', '4e3cc8', '4fbef9', 'feceb1', 'c4497a', 'e5b404', '2bee2b', 'e73a5d', 'bf390e', '841106', 'f6c2fa', '72545f', 'e2a148', 'a5e1d1', '80714b', '3011d6', '114145', '9e08d9', '1dd700', '1b8739', 'e779f7', '4b8513', 'c0efd9', '789df7', '744895', '28e932', '3fb5dc', '61fda0', '5da085', 'f4f2cc', '7ccf0', 'cc98f6', 'afc432', '2e4f48', 'a5f1df', 'c43a15', '9e3e83', '5e3471', '49d33a', '98373e', '26c0b', '95d0f', '57ea8f', '3846dd', 'd50929', '471905', '1adf87', '1b520c', '1f9038', 'ed2e4d', 'a93a51', '771b92', 'cd6a72', '5c5fb2', '92455c', 'a8e66e', 'f1ee72', 'dc4576', 'dc99b9', '4263f5', 'da0589', '1167fd', '65d1b0', '900bec', 'bd8e5c', '5cf782', 'ef71c7', '2abc79', '97ff2b', '5c895d', '394aad', '54d7b3', 'd6702e', '6a1700', 'd8167', '1e737', 'cd4ba1', '96f269', '88efc1', '55a508', '5cb338', 'dcb4a0', 'a60ce6', '7c1540', '541a8', '273aeb', 'f47199', 'c0dd', 'cce801', 'fc1d75', 'cb1e8e', '8ea9ad', '25abd5', 'da92c5', '59d2fd', '838375', '42ae15', 'aa99f2', '259082', '5b21fb', 'b8fa70', '862200', '7475c9', 'b8bbda', 'fc5302', 'd3f473', '41ce39', '4c279c', 'be208b', 'ff5bc9', '337d15', '749057', '28ebd5', 'ce8b8d', 'db136d', '80c939', 'c83e42', '3566cf', 'bd7bd1', 'f77e41', 'ed921e', 'c7531d', 'cdb044', 'f74328', '7ebc9b', '6e2d2d', '5d6328', 'f63b4c', 'c364ed', '98ba2', '612667', '5c0fd5', '25c5be', 'c50c2', 'e4d8ce', 'a1468f', 'c554b2', '3dcb59', 'edf0f2', 'c92afd', '2141eb', 'd8b867', '2efdbd', '354a43', 'c42412', '5c7fae', '7bcfb0', '6c398b', 'f31efd', '8e8ad8', '8c1312', '7ff11d', '785fdb', '18ab4c', 'e75be8', 'ed5b58', '6cfc74', '71aa8b', '55cd16', '7d5e33', 'aa8aa8', '73ea2', '200b75', '333086', 'be1fe8', 'b104dc', '6386d9', '11219e', 'c041f9', 'e46752', '51a135', 'd4b08f', '7d72f2', '617f0f', '4d1939', '40a8f3', '2d275b', 'fece0f', 'baa40b', '7b2f43', 'e9d9ae', 'ec91ec', '1b24e0', '869ae8', 'bdeb6a', '489294', '324687', '8ac27d', '6f86a4', '927621', '57ce00', '8fe4ca', 'd9dfb8', '8e9dc9', 'd13c20', '137f49', 'd6769a', '225bc', '4ed1b4', 'd4caad', 'bc8346', 'fdf76c', 'f02624', 'cf355c', '790a74', 'dc9016', 'a44f26', '686e46', '417eb8', 'dfdcfb', 'e89ed0', '344847', '8242b', '20386f', 'bf7d49', '425808', 'c0bcf4', '3dbbfe', '7698f2', '28ce26', 'b91fe3', 'c91f30', '15c4a', '3ff0eb', 'ca5165', '3184fe', '976d46', 'a91b86', 'ba734b', 'b9b95d', 'e215cb', 'b0bd3c', 'a1a6b9', '7b2da7', '541f8b', '9b1788', '3c2bef', 'e489fd', 'a7af8d', '520750', '34684d', 'ca478d', '6483ec', 'a309d9', '616fa7', 'e18496', '2a2e61', 'fc4f03', '8eb1e0', '6e6ab4', '63f324', '62dc85', '953a38', 'bc8a84', 'dfe50e', '8d565d', 'a60388', 'e38b09', 'f2f445', 'f9e530', '768233', '3aef1a', 'be9a9f', 'fec89a', '36ec5c', '8a76ff', '400662', '12e16c', 'a01b61', '2c7eec', 'fa622a', '1989e6', 'f1b9fd', 'ed3732', '663c3f', 'a2e09d', 'f361a2', '4c2acb', 'c5c67d', 'ef421f', '2d2666', 'e81c2f', 'c332ae', '14a9db', 'e97621', '3578c3', 'cb9013', '2078a2', 'ce3a90', '43075e', '9027b1', '82773d', '984889', 'cfa845', '711dbb', '20e3da', '8a8dcc', 'a398f2', '4b3994', '7d36d3', '806f54', '95f895', 'bec72b', 'a43704', 'af08e3', 'b7d1d4', 'cdfecf', 'b27eba', 'cd2dc5', '6ad1c6', 'a96670', '976ed5', '11e96e', '928296', '9640c3', 'd71921', '995daf', '2336cc', '7c39d3', 'ea6ae3', '5acce7', '3ca87a', 'acf96b', 'aa42cb', '13c23', '4b3592', '326d44', '6b4502', 'd6342c', 'b39ca3', '8dd591', '2c96c', 'f4b5d1', 'ec5b9f', 'fb5f6', '687c8f', 'ff5de8', 'aa5eb3', 'e6d156', '9bb106', '556c79', '7d557d', '2806aa', 'f738e5', '3f60dd', 'e84e47', 'b9396d', '3e5e11', 'e74336', '46c698', 'fb8183', '269cf6', '2b3c36', '108020', 'cc8e23', 'e867a7', 'd90fcd', 'a87bae', '30203b', '4b1a18', 'b84589', 'a159a', 'd85691', 'd56532', '1a9630', 'e856f9', 'e9ff27', 'a36629', '74e4f4', 'b3f3cf', 'b4aafa', 'cc96f7', '513531', 'b12021', '13c435', 'aa7f7', '5fca31', '5482b7', '2df731', '32704', 'f98c6', '1179dc', '32323c', 'e7d187', 'db2f73', '56718b', '54ee08', '484840', '72f6a7', 'dd5deb', 'cb4a78', 'cac20b', 'da3050', '34b86d', '3e8eb4', '24811e', 'ad5236', '743f7f', 'b53207', 'a65b47', '780085', 'a662f6', '5a97d5', '629b02', '72fd1c', 'd85baa', '578a8e', 'ad9db8', '6be579', '952df5', '1f22a0', '637a2a', '8fe89a', 'faa47c', '9c438e', '104570', '78b754', '82e043', 'd88875', 'e8052f', '8944a3', '1f7593', '849b30', '4480e8', '997998', 'c8f25d', '6c7cc3', 'b703c6', '4b6248', 'f129dd', 'd48d5d', 'e7aa3e', '28adb6', 'a5259b', 'e15c47', '15e748', '9c5d2d', '105800', 'c4f19c', '7adfee', '9e68b4', 'ffaa4c', '3194cc', '1c5deb', '9810ae', '15f82a', '455ea9', '60be20', '6d55ad', '1b2e5c', '2ceac1', 'f23ed2', '803a3', '21aee2', '72acc', '664e52', '678d1b', '73f3b7', '70f2e3', 'a0620', '95c457', '1e0f6b', 'b67162', '803239', 'a3d0b2', 'e58e9e', '8a7a18', '8e3b6c', '67f77a', 'd3fbd', '9adc1e', 'b50d70', '601a2f', 'd25564', '6000f7', '9aa5dd', '7649fb', '3bc741'];
    $('li a').each(function(index, element) {
        var randomColor = array_colors[Math.floor(Math.random() * array_colors.length)];
        $(element).css('background', '#' + randomColor);
    });

    showMenu(1.5);

    $('#mainmenu ul > li').hover(function() {
        $(this).removeClass('animated bounceInDown wobble').addClass('animated rubberBand hide');
        var list = $(this).children('ul').children('li').children('a');
        list.removeClass('animated bounceInDown wobble');
        var itemsLocal = list.get().reverse();
        var delayLocal = 0.5;
        for (var item in itemsLocal) {
            var current_item = $(itemsLocal[item]);
            current_item.removeClass('animated bounceInDown rubberBand');
            var css = 'background-color: ' + current_item.css('background-color') + ';';
            css += "-webkit-animation-delay:" + delayLocal + "s; -moz-animation-delay:" + delayLocal + "s;";
            css += "-webkit-animation-duration: 1s;-moz-animation-duration: 1s;";
            current_item.addClass('animated bounceInDown').removeClass('hide').attr('style', css);
            delayLocal += 0.15;
        }
    }, function() {
        $(this).removeClass('animated bounceInDown wobble').addClass('animated wobble');
    });


    $('div.menu_icon_box').hover(function() {
        $(this).removeClass('animated tada').addClass('animated tada');
        setTimeout(100);
    }, function() {
        $(this).removeClass('animated tada');
    });

    $('.menu_icon_image').click(function() {        
        if ($(this).hasClass('menu_icon_image_opened')) {
            $(this).removeClass('menu_icon_image_opened');
            hideMenu(0.15);
        } else {
            $(this).addClass('menu_icon_image_opened');
            showMenu(0.15);
        }
    });
});

function showMenu(delay) {
    menuFunction('bounceInDown', delay,1.75);
}
function hideMenu(delay) {
    menuFunction('slideOutLeft', delay,2.75);
}

function menuFunction(animation, delay, duration) {
    var items = $('#mainmenu ul > li a').not("ul li ul a").get().reverse();
    $('#mainmenu ul > li a').removeClass('animated bounceInDown slideOutLeft');
    for (var item in items) {
        var current_item = $(items[item]);
        var css = 'background-color: ' + current_item.css('background-color') + ';';
        css += "-webkit-animation-delay:" + delay + "s; -moz-animation-delay:" + delay + "s;";
        css += "-webkit-animation-duration: "+duration+"s;-moz-animation-duration: "+duration+"s;";
        current_item.addClass('animated ' + animation).attr('style', css);
        delay += 0.075;
    }
}


