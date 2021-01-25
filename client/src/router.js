import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            alias: "/cities",
            name: "cities",
            component: () => import("./components/CityList")
        },
        {
            path: "/cities",
            name: "cities",
            component: () => import("./components/CityList")
        },
        {
            path: "/cities/add",
            name: "addCity",
            component: () => import("./components/EditCity")
        },
        {
            path: "/cities/:id/edit",
            name: "editCity",
            component: () => import("./components/EditCity")
        },
        {
            path: "/cities/:id",
            name: "city",
            component: () => import("./components/City")
        },
        {
            path: "/report",
            name: "report",
            component: () => import("./components/Report")
        }
    ]
});