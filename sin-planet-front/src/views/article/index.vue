<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="200px"><ArticleAside /></el-aside>
      <el-main>Main</el-main>
    </el-container>
  </div>
</template>

<script setup>
import ArticleAside from "./aside/index.vue"
</script>

<style lang="scss" scoped></style>
