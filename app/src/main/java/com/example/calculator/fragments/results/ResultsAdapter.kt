package com.example.calculator.fragments.results

//class ResultsAdapter: RecyclerView.Adapter<ListAdapter.MyResultsHolder>(){

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = getItem(position)
//        holder.bind(item)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder.from(parent)
//    }
//    class ViewHolder private constructor(val binding: ListItemSleepNightBinding) : RecyclerView.ViewHolder(binding.root){
//        fun bind(item: Results) {
//            binding.sleep = item
//            binding.executePendingBindings()
//        }
//        companion object {
//            fun from(parent: ViewGroup): ViewHolder {
//                val layoutInflater = LayoutInflater.from(parent.context)
//                val binding = ListItemSleepNightBinding.inflate(layoutInflater, parent, false)
//                return ViewHolder(binding)
//            }
//        }
//    }

//    private var resultsList = emptyList<Results>()
//
//    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.MyResultsHolder {
//        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
//    }
//
//    override fun onBindViewHolder(holder: ListAdapter.MyResultsHolder, position: Int) {
//        val currentResult = resultsList[position]
//        holder.itemView.results.txt = currentResult.resultId.toString()
//    }
//
//    override fun getItemCount(): Int {
//        return resultsList.size
//    }
//
//    fun setData(results: List<Results>){
//        this.resultsList = results
//        notifyDataSetChanged()
//    }
//}