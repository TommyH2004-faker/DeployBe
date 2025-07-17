package com.example.WebsiteMHiepBe.security;
public class Endpoints {
    public static final String front_end_host = "http://localhost:3000";
    public static final String[] PUBLIC_GET_ENDPOINS = {
            "/images",
            "/users",
            "/users/**",
            "/users/*",
            "/reviews/get-all-reviews",
            "/genres/**",
            "/genres/*",
            "/plastic",
            "/plastic-items",
            "/plastic-items/**",
            "/plastic-items/*",
            "/plastic/**",
            "/orders/**",
            "/order/**",
            "reviews/search/countBy",
            "/feedback/totalFeedbacks",
            "/plastic/get-total",
            "/plastic/**",
            "/genre/**",
            "/reviews/**",
            "/images/**",
            "/images/**",
            "/users/search/existsByUsername/**",
            "/users/search/existsByEmail/**",
            "/users/search/existsByEmail",
            "users/search/existsByUsername",
            "/taikhoan/active-account/**",
            "/taikhoan/active-account",
            "/active-account",
            "/active-account/**",
            "/active-account/**",
            "/users/*/listCartItems",
            "/role/**",
            "/order-detail/*/book",
            "/order-details/**",
            "/users/*/listOrders",
            "/users/*/listRoles",
            "/users/*/listUsers",
            "/users/*",
            "/favorite-plastic/get-favorite-plastic/**",
            "/favorite-plastic/get-favorite-plastic/*",
            "/favorite-plastic/get-favorite-plastic",
            "/users/*/listFavoriteBooks",
            "/favorite-plastic/*/plastic",
            "/vnpay/**",
            "/cart-item/**",
            "/cart-item/get-all",
            "/cart-item/*/plastic",
            "/taikhoan/forgot-password",
            "/taikhoan/get-all-users",
            "/feedback/get-all-feedbacks",
            "/cart-items",
            "/cart-items/**",
            "/cart-items/*",
            "/feedbacks",
            "/feedbacks/**",
            "/feedbacks/*",

    };

    public static final String[] PUBLIC_POST_ENDPOINS = {
            "/taikhoan/register",
            "/taikhoan/register/**",
            "/taikhoan/register/*",
            "/taikhoan/authenticate",
            "/feedback/add-feedback",
            "/taikhoan/authenticate",
            "/taikhoan/**",
            "/orders/**",
            "/order/**",
            "/review/**",
            "/reviews/add-review/**",
            "/feedback/add-feedback",
            "/favorite-plastic/add-plastic",
            "/vnpay/create-payment/**",
            "/reviews/get-review/**",
            "/cart-item/add-item",
            "/cart-item/add-item/**",
            "/taikhoan/add-user",
            "/plastics/upload-images",
            "/plastics/upload-images",


    };


    public static final String[] PUBLIC_PUT_ENDPOINS = {
            "/cart-item/**",
            "/taikhoan/change-password",

            "/taikhoan/forgot-password",
            "/taikhoan/update-profile",
            "/user/**",
            "/taikhoan/change-avatar",
            "/user/update-profile",
            "/user/change-password",
            "/user/forgot-password",
            "/user/change-avatar",
            "/orders/update-order",
            "/orders/cancel-order",
            "/reviews/update-review",
            "/cart-item/update-item",
            "/taikhoan/update-user",
            "/genres/**",
    };
    public static final String[] PUBLIC_DELETE_ENDPOINS = {
            "/cart-items/**",
            "/favorite-plastic/delete-plastic",
            "/favorite-plastic/**",
            "/cart-item/**",
            "/cart-item/delete-item",
            "/cart-item/delete-item/**",
            "/genres/**",
    };
    public static final String[] ADMIN_ENDPOINS = {
            "/users",
            "/users/**",
            "/favorite-plastic/get-favorite-plastic/**",
            "/favorite-plastic//get-favorite-plastic/*",
            "/favorite-plastic//get-favorite-plastic",
            "/cart-items/add-item",
            "/cart-item/**",
            "/books/add-book/**",
            "/taikhoan/add-user/**",
            "/feedbacks/**",
            "/cart-item/**",
            "/cart-item/**",
            "/order-details/**",
            "/roles/**",
            "/favorite-plastic//**",
            "/favorite-plastic/add-plastic",
            "/cart-item/**",
            "/taikhoan/update-profile",
            "/taikhoan/change-avatar",
            "/feedback/add-feedback",
            "/taikhoan/forgot-password",
            "/**",
            "/api/image/upload",


    };







}
