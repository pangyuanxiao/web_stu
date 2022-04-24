<!--<template>-->
<!--&lt;!&ndash;  <div id="nav">&ndash;&gt;-->
<!--&lt;!&ndash;    <router-link to="/">Home</router-link> |&ndash;&gt;-->
<!--&lt;!&ndash;    <router-link to="/about">About</router-link>&ndash;&gt;-->
<!--&lt;!&ndash;  </div>&ndash;&gt;-->
<!--&lt;!&ndash;  <router-view/>&ndash;&gt;-->
<!--</template>-->

<template>
  <a-layout>
    <my-header></my-header>
    <router-view/>
    <my-footer></my-footer>
  </a-layout>
</template>



<script lang="ts">
import { defineComponent } from 'vue';
import MyHeader from '@/components/MyHeader.vue';
import MyFooter from '@/components/MyFooter.vue';

export default defineComponent({
  name: 'app',
  components: {
    MyHeader,
    MyFooter
  },
});
</script>



<style>
#components-layout-demo-top-side .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}

.ant-row-rtl #components-layout-demo-top-side .logo {
  float: right;
  margin: 16px 0 16px 24px;
}

.site-layout-background {
  background: #fff;
}
</style>
