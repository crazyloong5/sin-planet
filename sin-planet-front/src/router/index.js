import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/login",
      name: "login",
      component: () => import("@/views/start/Login.vue"),
    },
    {
      path: "/",
      name: "home",
      component: () => import("@/views/HomeView.vue"),
      children: [
        {
          path: "/article",
          name: "article",
          component: () => import("@/views/article/index.vue"),
        },
        {
          path: "/movie",
          name: "movie",
          component: () => import("@/views/movie/index.vue")
        }
      ],
    },
  ],
});

export default router;
