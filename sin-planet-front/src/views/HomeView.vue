<template>
  <div class="common-layout">
    <el-container>
      <el-header><Menu /></el-header>
      <!-- 容器 -->
      <el-main><RouterView></RouterView></el-main>
    </el-container>
  </div>
</template>

<script setup>
import Menu from "@/components/home/menu/index.vue";
</script>

<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
}
</style>
