<template>
    <div class="image-component">
        <b-row>
            <b-col cols="4"> 
              <div class="image">
  <img src="https://picsum.photos/600/300/?image=25" class="image">
              </div>
        </b-col>
        </b-row>
    </div>
</template>
<script>


import PicZoom from 'vue-piczoom'
export default {
    name: 'ProductImageComponent',
    components: {
      PicZoom
    }
}

</script>
<style>
.image-component{
  padding: 10px;
  margin: auto;
}
.image{
  width: 300px;
  height: 300px;
  margin-left: 20px;
  margin-right: 20px;
  margin-top: 30px;
  margin-bottom: 20px;
}
</style>