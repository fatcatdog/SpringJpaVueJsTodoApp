<template>
  <div id="task-list" class="task-list">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Description</th>
          <th>Due Date</th>
          <th>Stage</th>
        </tr>
      </thead>
      <tbody>
        <tr
            :key="task.id"
            v-for="task in tasks"
          >
            <td>{{ task.id }}</td>
            <td>{{ task.name }}</td>
            <td>{{ task.description }}</td>
            <td>{{ task.dueDate }}</td>
            <td>{{ task.stage }}</td>
          </tr>
        </tbody>
    </table>
  </div>
</template>

<script>
  export default {
    name: 'task-list',
    props: {
      tasks: Array,
    },
  }
</script>

<style scoped>

.task-list {
text-align: center;

}
</style>
