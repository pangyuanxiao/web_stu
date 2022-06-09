<template>
  <a-layout style="padding: 24px 0; background: #fff">
    <a-layout-sider width="200" style="background: #fff">
      <a-menu
          mode="inline"
          v-model:selectedKeys="selectedKeys2"
          v-model:openKeys="openKeys"
          style="height: 100%"
      >
        <a-sub-menu key="sub1">
          <template #title>
                <span>
                  <user-outlined />
                  subnav 1
                </span>
          </template>
          <a-menu-item key="1">option11111</a-menu-item>
          <a-menu-item key="2">option2</a-menu-item>
          <a-menu-item key="3">option3</a-menu-item>
          <a-menu-item key="4">option4</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub2">
          <template #title>
                <span>
                  <laptop-outlined />
                  subnav 2
                </span>
          </template>
          <a-menu-item key="5">option5</a-menu-item>
          <a-menu-item key="6">option6</a-menu-item>
          <a-menu-item key="7">option7</a-menu-item>
          <a-menu-item key="8">option8</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub3">
          <template #title>
                <span>
                  <notification-outlined />
                  subnav 3
                </span>
          </template>
          <a-menu-item key="9">option9</a-menu-item>
          <a-menu-item key="10">option10</a-menu-item>
          <a-menu-item key="11">option11</a-menu-item>
          <a-menu-item key="12">option12</a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
    <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">


      <a-list item-layout="vertical" size="large" :grid="{gutter: 20 , column : 3}"  :data-source="ebooks">

        <template #renderItem="{ item }">
          <a-list-item key="item.name">

<!--            三个小图标-->
            <template #actions>
          <span v-for="{ type, text } in actions" :key="type">
            <component v-bind:is="type" style="margin-right: 8px" />
            {{ text }}
          </span>
            </template>

            <a-list-item-meta :description="item.description">

<!--              页面跳转-->
              <template #title>
                <a :href="item.href">{{ item.name }}</a>
              </template>
<!--              小图标-->
              <template #avatar><a-avatar :src="item.cover"/></template>
            </a-list-item-meta>

          </a-list-item>
        </template>
      </a-list>

    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
//import { defineComponent ,onMounted,ref,reactive,toRef} from 'vue';
import { defineComponent ,onMounted,ref} from 'vue';

import axios from "axios";






export default defineComponent({
  name: 'Home',

  setup(){
    console.log("setup");
    //响应式数据
    const ebooks = ref();

    /*这就相当于一个对象
    const ebooks1 = reactive({books:[]})*/

    //相当于mount
    onMounted(()=>{
      console.log("mount222")
      axios.get("/ebook/list/all").then((resp) =>{

        const data = resp.data;
        ebooks.value = data.content;

        //ebooks1.books = data.content.list;
      });
    });

    return {
      ebooks,
      /*ebooks2就是把book1的books转成ref
      ebooks2 : toRef(ebooks1,"books"),*/



      pagination: {
        onChange: (page: any) => {
          console.log(page);
        },
        pageSize: 3,
      },
      actions: [
        { type: 'StarOutlined', text: '156' },
        { type: 'LikeOutlined', text: '156' },
        { type: 'MessageOutlined', text: '2' },
      ],
    }


  }

});
</script>


<style scoped>
.ant-avatar {
  width: 50px;
  height: 50px;
  line-height: 50px;
  border-radius: 8%;
  margin: 5px 0;
}
</style>
