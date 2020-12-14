<template>
    <ProjectAssessButton :TableRow="TableRow"></ProjectAssessButton>
</template>

<script>
import ProjectAssessButton from '@/components/forms/buttons/assessmentResult/ProjectAssessButton'
export default {
    components:{
        ProjectAssessButton
    },
    props: ["TableRow"],
}
</script>

<style>

</style>