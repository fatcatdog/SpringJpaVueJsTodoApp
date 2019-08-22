//This page renders if our user types in a random undefined route
<template>
  <div id="not-found">
  <div class="sectionheader">
  <h1>404</h1>
  <p>Sorry it looks like this page does not exist. Please try click the link in the upper left corner of this page to go back :(</p>
    <div class="imagestyle">
    <img src="../assets/olive.jpg">
    </div>

  </div>
  </div>
</template>

<script>

export default {
  name: 'not-found',

  }
</script>
//our styling
<style scoped>
.sectionheader {
  text-align: center;
}

img {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}
</style>
