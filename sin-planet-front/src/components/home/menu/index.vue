<template>
  <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    :ellipsis="false"
    @select="handleSelect"
  >
    <el-menu-item style="padding-left: 0">
      <img
        style="width: 100px"
        src="../../../assets/img/sin-planet.png"
        alt="Element logo"
      />
      <el-text size="large" tag="b" style="font-family: sans-serif"
        >Sin-Planet</el-text
      >
    </el-menu-item>
    <div class="flex-grow" />
    <el-menu-item index="/article"
      ><el-icon><Reading /></el-icon>文章</el-menu-item
    >
    <el-menu-item index="/movie"
      ><el-icon><VideoCamera /></el-icon>电影</el-menu-item
    >
    <el-menu-item index="/"
      ><el-icon><ChatRound /></el-icon>在线聊天室</el-menu-item
    >
    <el-sub-menu index="2">
      <template #title>个人页面</template>
      <el-menu-item index="2-1">item one</el-menu-item>
      <el-menu-item index="2-2">item two</el-menu-item>
      <el-menu-item index="2-3">item three</el-menu-item>
      <el-sub-menu index="2-4">
        <template #title>item four</template>
        <el-menu-item index="2-4-1">item one</el-menu-item>
        <el-menu-item index="2-4-2">item two</el-menu-item>
        <el-menu-item index="2-4-3">item three</el-menu-item>
      </el-sub-menu>
    </el-sub-menu>
  </el-menu>
</template>

<script setup>
import router from "@/router";
import { ref } from "vue";

const activeIndex = ref("1");
const handleSelect = (key, keyPath) => {
  router.push(key);
};
</script>

<style>
.flex-grow {
  flex-grow: 1;
}

* {
  margin: 0;
}
</style>
