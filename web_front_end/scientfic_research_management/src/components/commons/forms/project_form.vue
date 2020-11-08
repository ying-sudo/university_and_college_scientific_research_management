<template>
  <div>
    <mu-container>
      <mu-form :model="form" class="mu-demo-form" :label-position="labelPosition" label-width="100">
        <mu-form-item prop="input" label="项目名称">
          <mu-text-field v-model="form.input"></mu-text-field>
        </mu-form-item>

        <mu-form-item prop="select" label="学科门类">
          <mu-select v-model="form.select">
            <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
          </mu-select>
        </mu-form-item>

        <mu-form-item prop="select" label="一级学科">
          <mu-select v-model="form.select">
            <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
          </mu-select>
        </mu-form-item>

        <mu-form-item prop="radio" label="项目性质">
          <mu-radio v-model="form.radio" value="male" label="Male"></mu-radio>
          <mu-radio v-model="form.radio" value="female" label="Female"></mu-radio>
        </mu-form-item>

        <mu-form-item prop="select" label="项目级别">
          <mu-select v-model="form.select">
            <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
          </mu-select>
        </mu-form-item>

        <mu-form-item prop="select" label="项目分类">
          <mu-select v-model="form.select">
            <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
          </mu-select>
        </mu-form-item>

        <mu-form-item prop="input" label="负责人学工号">
          <mu-text-field v-model="form.input"></mu-text-field>
        </mu-form-item>

        <mu-form-item prop="textarea" label="备注">
          <mu-text-field multi-line :rows="3" :rows-max="6" v-model="form.textarea"></mu-text-field>
        </mu-form-item>

      </mu-form>
    </mu-container>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        options: [
          'Option 1', 'Option 2', 'Option 3', 'Option 4',
          'Option 5', 'Option 6', 'Option 7', 'Option 8',
          'Option 9', 'Option 10'
        ],
        labelPosition: 'top',
        form: {
          input: '',
          select: '',
          date: '',
          radio: '',
          textarea: ''
        }
      }
    }
  };
</script>


<style>
 .mu-demo-form {
    width: 100%;
    max-width: 500px;
  }
</style>
